<%@ page language="java" contentType="text/html;charset=UTF-8" session="true" %>
<%@ taglib prefix="ano" uri="http://www.anotheria.net/ano-tags" %>
<%@ taglib prefix="mos" uri="http://www.moskito.org/inspect/tags" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../../shared/jsp/Header.jsp" flush="false"/>
<section id="main">
    <div class="content">
        <div class="box">
            <div class="box-title">
                <h3 class="pull-left">
                    Errors in inmemory error catchers. (BETA)
                </h3>
                <div class="box-right-nav">
                    <a href="" class="tooltip-bottom" title="Help"><i class="fa fa-info-circle"></i></a>
                </div>
            </div>

            <div id="collapseErrors" class="box-content accordion-body collapse in hscrollbar errors-box">
                <ano:notPresent name="catchers">
                    No catchers active or no errors have been caught yet.
                </ano:notPresent>
                <ano:present name="catchers">
                <table class="table table-striped tree">
                    <thead>
                    <tr>
                        <th>Exception</th>
                        <th>Catches</th>
                    </tr>
                    </thead>
                    <tbody>
                    <ano:iterate name="catchers" type="net.anotheria.moskito.webui.shared.api.ErrorCatcherAO" id="catcher">
                        <tr>
                            <td><mos:deepLink  href="mskError?error=${catcher.name}">${catcher.name}</mos:deepLink ></td>
                            <td>${catcher.count}</td>
                        </tr>
                    </ano:iterate>
                    </tbody>
                </table>
                </ano:present>
            </div>
        </div>

    <div class="box">
        <div class="box-title">
            <h3 class="pull-left">
                Configuration help.
            </h3>
            <div class="box-right-nav">
                <a href="" class="tooltip-bottom" title="Help"><i class="fa fa-info-circle"></i></a>
            </div>
        </div>

        <div id="collapseConfig" class="box-content accordion-body collapse in errors-box">
            <p>Check the field <em>errorHandlingConfig</em> in the <mos:deepLink  href="mskConfig">configuration section</mos:deepLink > for information about currently configured error catchers. For more help on configuration options visit <a href="https://confluence.opensource.anotheria.net/display/MSK/MoSKito-Essential+Configuration+Guide">the configuration guide.</a>
            </p>
        </div>
    </div>
    </div>

    </div>
    <jsp:include page="../../shared/jsp/Footer.jsp" flush="false"/>

</section>
</body>
</html>