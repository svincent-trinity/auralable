
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html)(implicit flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
  <head>
    <title>"""),_display_(/*7.13*/title),format.raw/*7.18*/("""</title>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*8.50*/routes/*8.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*8.97*/("""">
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura-earthly.css" type="text/css">

    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*11.55*/routes/*11.61*/.Assets.versioned("images/favicon.png")),format.raw/*11.100*/("""">

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    

    <!-- Libraries for React --
    <script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin></script>-->
  </head>
  <body>
    """),_display_(/*23.6*/flash/*23.11*/.get("error")),format.raw/*23.24*/("""
    """),_display_(/*24.6*/content),format.raw/*24.13*/("""
    """),_display_(/*25.6*/scalajs/*25.13*/.html.scripts("play-videos-client", routes.Assets.versioned(_).toString, name => getClass.getResource(s"/public/$name") != null)),format.raw/*25.141*/("""

  """),format.raw/*27.3*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(flash)

  def f:((String) => (Html) => (Flash) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (flash) => apply(title)(content)(flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-07-22T22:16:50.451
                  SOURCE: /Users/samvincent/Desktop/AuralAble/server/app/views/main.scala.html
                  HASH: 3057e2aa416b7fa9a253377a158fb58da2842556
                  MATRIX: 739->1|886->55|913->56|984->101|1009->106|1093->164|1107->170|1168->211|1352->368|1367->374|1428->413|1829->790|1843->795|1877->808|1909->814|1937->821|1969->827|1985->834|2135->962|2166->966
                  LINES: 21->1|26->2|27->3|31->7|31->7|32->8|32->8|32->8|35->11|35->11|35->11|47->23|47->23|47->23|48->24|48->24|49->25|49->25|49->25|51->27
                  -- GENERATED --
              */
          