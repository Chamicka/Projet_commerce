<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="classHeader">
	<br />
	<br />
	<h1 id="nomSite">Site e-commerce</h1>
</header>

<div class="container" style="width: 100%" >

	<!-- Navigation -->
	<div class="row" >
		<nav class="navbar navbar-inverse" role="navigation">
			<div class="container" style="width: 100%">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand visible-xs-inline-block nav-logo" href="/"><img
						src="/images/logo-dark-inset.png" class="img-responsive" alt=""></a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav js-nav-add-active-class">
						<li><a href="${pageContext.request.contextPath}/site/welcome">Accueil</a></li>
					</ul>
					
					<c:forEach var="categorie" items="${listeCats}">
						<ul><li><a href="${pageContext.request.contextPath}/site/produitsClient/${categorie.id}">${categorie.nom}</a></li>
						</ul></c:forEach>
					
					
					<ul class="nav navbar-nav navbar-right hidden-xs">
						<a type="button" class="navbar-btn btn btn-gradient-blue"
							am-latosans="bold" href="${pageContext.request.contextPath}/site/admin/categories">Admin</a>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
		</nav>
	</div>
</div>