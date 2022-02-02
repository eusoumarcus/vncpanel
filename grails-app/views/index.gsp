<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Assets Manager</title>
    
</head>
<body>

<div id="content" class='centerlogin' role="main">
    <div class="container">
        <section class="row centerlogin">
            
            <form class="box">
                 <div class="field">
                     <label class="label">Email</label>
                     <div class="control">
                        <input class="input" type="email" placeholder="e.g. alex@example.com">
                    </div>
                 </div>

                <div class="field">
    <label class="label">Password</label>
    <div class="control">
      <input class="input" type="password" placeholder="********">
    </div>
  </div>

  <button class="button is-primary">Sign in</button>
</form>

        </section>
        <section class="row">
        <div id="controllers" role="navigation">
                <h2>Available Controllers:</h2>
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                        </li>
                    </g:each>
                </ul>
            </div>
        </section>
    </div>
</div>

</body>
</html>
