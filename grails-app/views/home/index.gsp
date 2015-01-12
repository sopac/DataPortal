<html>

<head>
    <title><b style="font-size: 46px;">Pacific GeoScience Data Portal</b></title>
    <meta name="layout" content="kickstart"/>
</head>

<body>

<section id="intro" class="first">
    <h3>Welcome to the Pacific GeoScience Data Portal</h3>

    <p align="justify">
        The <b>Pacific GeoScience Data Portal</b> is an ongoing initiative by the GeoScience Division of Secretariat of the Pacific Community to implement
    an all-encompassing platform for collating, cataloguing, dessiminating a wide-range of geoscientifc information and data-sets in the public domain.
        <br/><br/>
        The portal is continously updated to provide current and relevant information in regards to geo-hazards, deep sea minerals, climate change adaptations, water and sanitation, geosurveys, hydrological mapping,
        earth resources and other related thematic areas for the Pacific Region. For information, please email <a href="mailto:datarequest@sopac.org">datarequest@sopac.org</a>.

    </p>

    <g:link class="btn btn-large btn-primary" controller="nextSteps">More Information</g:link>

</section>


<br/>
<div style="border: 2px solid; border-color: lightblue;">
    <h3 align="center" style="background-color: lightblue; padding: 6px; margin-top: -2px; color: #000000"><b>Thematic Areas</b></h3>

    <section style="margin-top: -60px" id="info">
        <div class="row">
            <g:each in="${dataportal.Theme.list(max: 4)}">
            <div class="col-md-3">
                <div class="center">
                    <a href="#">
                    <img class="frontpageImage" src="${resource(plugin: 'kickstart', dir: 'images/frontpage', file: 'bs-docs-twitter-github.png')}"/>
                    <h5>${it.name}</h5>
                    <i>${it.acronym}</i>
                    </a>
                </div>
                <p></p>
            </div>
            </g:each>
        </div>

        <div class="row">
            <g:each in="${dataportal.Theme.list(max: 4, offset: 4)}">
                <div class="col-md-3">
                    <div class="center">
                        <a href="#">
                        <img class="frontpageImage" src="${resource(plugin: 'kickstart', dir: 'images/frontpage', file: 'bs-docs-twitter-github.png')}"/>
                            <h5>${it.name}</h5>
                            <i>${it.acronym}</i>
                        </a>
                    </div>
                    <p></p>
                </div>
            </g:each>
        </div>

    </section>
</div>


<br/>
<div style="border: 2px solid; border-color: lightcoral;">
    <h3 align="center" style="background-color: lightcoral; padding: 6px; margin-top: -2px; color: #000000"><b>Data Types</b></h3>

    <section style="margin-top: -60px" id="info">
        <div class="row">
            <g:each in="${dataportal.DataType.list(max: 3)}">
                <div class="col-md-4">
                    <div class="center">
                        <a href="#">
                            <img class="frontpageImage" src="${resource(plugin: 'kickstart', dir: 'images/frontpage', file: 'bs-docs-twitter-github.png')}"/>
                            <h5>${it.type}</h5>
                        </a>
                    </div>
                    <p></p>
                </div>
            </g:each>
        </div>

        <div class="row">
            <g:each in="${dataportal.DataType.list(max: 3, offset: 3)}">
                <div class="col-md-4">
                    <div class="center">
                        <a href="#">
                            <img class="frontpageImage" src="${resource(plugin: 'kickstart', dir: 'images/frontpage', file: 'bs-docs-twitter-github.png')}"/>
                            <h5>${it.type}</h5>
                        </a>
                    </div>
                    <p></p>
                </div>
            </g:each>
        </div>
    </section>
</div>

<br/>
<div style="border: 2px solid; border-color: lightseagreen;">
    <h3 align="center" style="background-color: lightseagreen; padding: 6px; margin-top: -2px; color: #000000"><b>Countries</b></h3>

    <section style="margin-top: -60px" id="info">
        <div class="row">
            <g:each in="${dataportal.Country.list(max: 6, sort: "name")}">
                <div class="col-md-2">
                    <div class="center">
                        <a href="#">
                            <img class="frontpageImage" style="width: 120px !important; height: 70px !important;" src="${resource(dir: 'images/flags', file: it.flag)}"/>
                            <h5>${it.name}</h5>
                        </a>
                    </div>
                    <p></p>
                </div>
            </g:each>
        </div>

        <div class="row">
            <g:each in="${dataportal.Country.list(max: 6, offset: 6, sort: "name")}">
                <div class="col-md-2">
                    <div class="center">
                        <a href="#">
                            <img class="frontpageImage" style="width: 120px !important; height: 70px !important;" src="${resource(dir: 'images/flags', file: it.flag)}"/>
                            <h5>${it.name}</h5>
                        </a>
                    </div>
                    <p></p>
                </div>
            </g:each>
        </div>

        <div class="row">
            <g:each in="${dataportal.Country.list(max: 6, offset: 12, sort: "name")}">
                <div class="col-md-2">
                    <div class="center">
                        <a href="#">
                            <img class="frontpageImage" style="width: 120px !important; height: 70px !important;" src="${resource(dir: 'images/flags', file: it.flag)}"/>
                            <h5>${it.name}</h5>
                        </a>
                    </div>
                    <p></p>
                </div>
            </g:each>
        </div>

        <div class="row">
            <g:each in="${dataportal.Country.list(max: 6, offset: 18, sort: "name")}">
                <div class="col-md-2">
                    <div class="center">
                        <a href="#">
                            <img class="frontpageImage" style="width: 120px !important; height: 70px !important;" src="${resource(dir: 'images/flags', file: it.flag)}"/>
                            <h5>${it.name}</h5>
                        </a>
                    </div>
                    <p></p>
                </div>
            </g:each>
        </div>

    </section>
</div>



</body>

</html>
