var mymap = L.map('mapid').setView([53.468419, 18.758323], 13)

function addMap() {

    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoibWtyYSIsImEiOiJjazl6dzZuMzMwaXgzM2ZudjdpcnducGZkIn0.if56m-7sdPjwzBnLdnfxTQ', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>, implementation © Mikołaj Krawczak',
        maxZoom: 18,
        id: 'mapbox/streets-v11',
        tileSize: 512,
        zoomOffset: -1,
        accessToken: 'your.mapbox.access.token'
    }).addTo(mymap);

}

const redIcon = L.icon({
    iconUrl: '/mk/img/red-dot.png',
    iconSize: [42, 42],
    iconAnchor: [21, 42],
    popupAnchor: [0, -42]
});

const greenIcon = L.icon({
    iconUrl: '/mk/img/green-dot.png',
    iconSize: [42, 42],
    iconAnchor: [21, 42],
    popupAnchor: [0, -42]
});
var mouse = false;
var refresh = 0;
const div = document.querySelector("#mapid")

// div.addEventListener("mousemove", mouseMove);

function mouseMove() {
    mouse = true;
    setTimeout(mouseStop, 10000)
}

function mouseStop() {
    mouse = false;

}

var audio = new Audio('/mk/sounds/bim.mp3')

function getPopups() {
    $.getJSON('/mk/rest/api/devices', function (list) {
        refresh++;
        if (refresh > 240) {
            location.reload();
        }
        removeMarkers();
        for (var i = 0; i < list.length; i++) {
            var device = list[i];
            var detailsAmount = device.deviceDetails.length;
            var detailsList = device.deviceDetails;
            var detailsContent = " "
            for (var x = 0; x < detailsAmount; x++) {
                detailsContent = detailsContent + detailsList[x].type + ": " + detailsList[x].value + "</br>";
            }
            var popupContent = device.address + "</br> ip: " + device.ip + "</br>" + detailsContent;


            if (device.status === "ok") {
                var marker = L.marker([device.lat, device.lng], {icon: greenIcon})
                    .addTo(mymap)
                    .bindPopup(popupContent);
            } else {
                playAudio();
                L.marker([device.lat, device.lng], {icon: redIcon})
                    .addTo(mymap)
                    .bindPopup("<b> Problem z " + device.status + "</b></br>" + popupContent);
            }
        }

    })
        .fail(function () {
            alert("Problem z odświeżeniem danych, skontaktuj się z administratorem.")
        })

}

function removeMarkers() {
    mymap.eachLayer(function (layer) {
        mymap.removeLayer(layer)
    }, this)
    addMap();
}

function playAudio() {
    audio.play().then(r => console.log("alert audio played"));
}

getPopups();
setInterval(getPopups, 60000);
