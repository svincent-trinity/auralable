// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/samvincent/Desktop/AuralAble/server/conf/routes
// @DATE:Wed Jul 22 16:34:28 PDT 2020


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
