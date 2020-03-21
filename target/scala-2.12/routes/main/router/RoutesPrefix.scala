// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/siddharthmehta/Desktop/Carnegie Mellon University Material/18-655 Service Oriented Computing/Homework 3/Backend/conf/routes
// @DATE:Fri Feb 28 22:26:50 PST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
