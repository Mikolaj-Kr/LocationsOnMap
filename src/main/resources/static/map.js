var mymap = L.map('mapid').setView([53.4841100, 18.7536600], 13)

L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoibWtyYSIsImEiOiJjazl6dzZuMzMwaXgzM2ZudjdpcnducGZkIn0.if56m-7sdPjwzBnLdnfxTQ', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>, implementation © Mikołaj Krawczak',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'your.mapbox.access.token'
}).addTo(mymap);

// var marker = L.marker([53.501757, 18.778621])
//     .addTo(mymap)
//     .bindPopup("jestem na Paderewskiego").openPopup();

console.log('/rest/api/devices');
$.getJSON('/rest/api/devices', function (list) {

    for (var i = 0; i < list.length; i++) {
        const device = list[i];
        var marker = L.marker([device.lat, device.lng])
            .addTo(mymap)
            .bindPopup(device.status).closePopup();
    }

})


//
// var marker = L.marker([53.501757, 18.778621])
//     .addTo(mymap)
//     .bindPopup("Jestem na paderewskiego").closePopup();


// var popup = L.bindPopup()
// .setLatLng([53.501757, 18.778621])
//     .setContent("Jestem na paderewskiego")
//     .openOn(mymap);


// 53.454509, 18.719909
