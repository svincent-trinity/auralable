
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String)(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("AuralAble")/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""



  """),format.raw/*7.3*/("""<!--<h2>Draw stuff</h2>

    <input type="hidden" id="uploadShape" value=""""),_display_(/*9.51*/routes/*9.57*/.Application.uploadShape()),format.raw/*9.83*/("""">
    <input type="hidden" id="getShapes" value=""""),_display_(/*10.49*/routes/*10.55*/.Application.getShapes()),format.raw/*10.79*/("""">

	--><input type="hidden" id="csrfToken" value=""""),_display_(/*12.49*/helper/*12.55*/.CSRF.getToken.value),format.raw/*12.75*/(""""><!--

    <button type="button" id="draw-line">Draw A Line</button>
    <button id="draw-rectangle">Draw a Rectangle</button>
    <button id="color-black">Black</button>
    <button id="color-red">Red</button>
    <button id="color-white">White</button>

    <br>
    <canvas id="canvas" style="border-style: solid" width="800" height="600"></canvas>


  <div id="root"></div>-->
  <h2>Welcome to AuralAble!</h2>
  <p>The free, open source aural skills trainer</p>

  <input type="hidden" id="notePlayed"></input>

  <text id="levelOn">Click the button to begin! </text> 
  <br>
  <button id="lvlbutton" onClick="play()">Next Level</button>

  <table id="notesTable">
      <th>Notes</th>
  </table>
  
  <audio id = "C4">
    <source src=""""),_display_(/*39.19*/routes/*39.25*/.Assets.versioned("sounds/virtual-piano/C4.mp3")),format.raw/*39.73*/("""" type="audio/mpeg">
  </audio>


  <audio id = "D4">
    <source src=""""),_display_(/*44.19*/routes/*44.25*/.Assets.versioned("sounds/virtual-piano/D4.mp3")),format.raw/*44.73*/("""" type="audio/mpeg">
  </audio>


 <audio id = "E4">
    <source src=""""),_display_(/*49.19*/routes/*49.25*/.Assets.versioned("sounds/virtual-piano/E4.mp3")),format.raw/*49.73*/("""" type="audio/mpeg">
  </audio>
  <audio id = "F4">
    <source src=""""),_display_(/*52.19*/routes/*52.25*/.Assets.versioned("sounds/virtual-piano/F4.mp3")),format.raw/*52.73*/("""" type="audio/mpeg">
  </audio>



  <audio id = "G4">
    <source src=""""),_display_(/*58.19*/routes/*58.25*/.Assets.versioned("sounds/virtual-piano/G4.mp3")),format.raw/*58.73*/("""" type="audio/mpeg">
  </audio>


  <audio id = "A4">
    <source src=""""),_display_(/*63.19*/routes/*63.25*/.Assets.versioned("sounds/virtual-piano/A4.mp3")),format.raw/*63.73*/("""" type="audio/mpeg">
  </audio>


  <audio id = "B4">
    <source src=""""),_display_(/*68.19*/routes/*68.25*/.Assets.versioned("sounds/virtual-piano/B4.mp3")),format.raw/*68.73*/("""" type="audio/mpeg">
  </audio>

  <audio id = "C5">
    <source src=""""),_display_(/*72.19*/routes/*72.25*/.Assets.versioned("sounds/virtual-piano/C5.mp3")),format.raw/*72.73*/("""" type="audio/mpeg">
  </audio>


  <!--<script src="WebMIDIAPI.min.js"></script>    -->
  <script src=""""),_display_(/*77.17*/routes/*77.23*/.Assets.versioned("javascript/handleMidi.js")),format.raw/*77.68*/(""""></script>

""")))}),format.raw/*79.2*/("""
"""))
      }
    }
  }

  def render(message:String,request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(message)(request,flash)

  def f:((String) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (message) => (request,flash) => apply(message)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-07-24T10:31:13.059
                  SOURCE: /Users/samvincent/Desktop/AuralAble/server/app/views/index.scala.html
                  HASH: a21dec16405d8aaff2f87a7f830400e0e5964fb1
                  MATRIX: 757->1|923->74|950->76|975->93|1014->95|1046->101|1147->176|1161->182|1207->208|1285->259|1300->265|1345->289|1424->341|1439->347|1480->367|2250->1110|2265->1116|2334->1164|2433->1236|2448->1242|2517->1290|2615->1361|2630->1367|2699->1415|2796->1485|2811->1491|2880->1539|2980->1612|2995->1618|3064->1666|3163->1738|3178->1744|3247->1792|3346->1864|3361->1870|3430->1918|3528->1989|3543->1995|3612->2043|3744->2148|3759->2154|3825->2199|3869->2213
                  LINES: 21->1|26->2|27->3|27->3|27->3|31->7|33->9|33->9|33->9|34->10|34->10|34->10|36->12|36->12|36->12|63->39|63->39|63->39|68->44|68->44|68->44|73->49|73->49|73->49|76->52|76->52|76->52|82->58|82->58|82->58|87->63|87->63|87->63|92->68|92->68|92->68|96->72|96->72|96->72|101->77|101->77|101->77|103->79
                  -- GENERATED --
              */
          