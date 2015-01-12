<div class="" style="">
    <ul class="nav nav-tabs" data-role="listview" data-split-icon="gear" data-filter="true">

        <li class="controller${params.controller == "home" ? " active" : ""}">
            <g:link controller="home" action="index">
                <b>Home</b>
            </g:link>
        </li>

        <g:each status="i" var="c" in="${grailsApplication.controllerClasses.sort { it.logicalPropertyName }}">
            <g:if test="${!Global.disabledMenu.contains(c.logicalPropertyName.capitalize())}">
                <li class="controller${params.controller == c.logicalPropertyName ? " active" : ""}">
                    <g:link controller="${c.logicalPropertyName}" action="index">
                        <g:message code="${c.logicalPropertyName}.label"
                                   default="${c.logicalPropertyName.capitalize()}"/>
                    </g:link>
                </li>
            </g:if>
        </g:each>

    </ul>
</div>
