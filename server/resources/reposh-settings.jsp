<%@ include file="/include-internal.jsp"%>
<jsp:useBean id="gitsettings" scope="request" type="java.lang.String"/>

<div>Specify git settings used to checkout main repository. This should be same as for <em>repo init</em></div>
<jsp:include page="${gitsettings}"/>

