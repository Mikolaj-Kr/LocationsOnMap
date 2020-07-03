<html lang="pl">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>Lista urządzeń</title>
</head>
<body>

<div class="functionalDevices">
    <h1 style="align-content: center">Wszystkie urządzenia</h1>
    <div class="table-responsive-md">
        <table class="table table-border table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col" class="text-center">Urządzenie</th>
                <th scope="col" class="text-center">Informacje</th>
            </tr>
            </thead>
            <tbody>
            <#list devicesList as device>
                <tr <#if device.status == 'ok'> <#else> bgcolor="red" </#if>>
                    <td class="clickable-row">${device.address}</td>
                    <td class="clickable-row">
                        <#list device.deviceDetails as detail>
                            ${detail.type} ${detail.value} ${detail.status};
                        </#list>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>

<div class="faultyDevices">
    <h1 style="align-content: center">Urządzenia niesprawne</h1>
    <table class="table table-border table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col" class="text-center">Urządzenie</th>
            <th scope="col" class="text-center">Informacje</th>
        </tr>
        </thead>
        <tbody>
        <#list devicesList as device>
            <#if device.status == "ok"> <#else>
            <tr>
                <td class="clickable-row">${device.address}</td>
                <td class="clickable-row">
                    <#list device.deviceDetails as detail>
                        ${detail.type} ${detail.value} ${detail.status};
                    </#list>
                </td>
            </tr>
            </#if>
        </#list>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>

</body>
</html>
