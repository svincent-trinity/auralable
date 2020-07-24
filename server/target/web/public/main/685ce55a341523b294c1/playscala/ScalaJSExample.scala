package playscala

import shared.SharedMessages
import org.scalajs.dom
import org.querki.jquery._


import slinky.core._
import slinky.web.ReactDOM
import slinky.web.html._
import scala.collection.mutable.ArrayBuffer

import org.scalajs.dom
import org.scalajs.dom.document
import scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.html

import org.scalajs.dom.raw.HTMLImageElement

import scala.scalajs.js
import scala.scalajs.js.annotation._
import play.api.libs.json.Json

import scala.scalajs.js.JSON
import scala.scalajs.js.annotation.JSExportTopLevel
import scala.util._
import org.scalajs.dom.experimental.Fetch
import org.scalajs.dom.experimental.RequestInit
import org.scalajs.dom.experimental.HttpMethod
import org.scalajs.dom.experimental.Headers
import org.scalajs.dom.experimental.RequestMode
import scala.scalajs.js.Thenable.Implicits._

import play.api.libs.json.JsSuccess
import play.api.libs.json.JsError

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext




object ScalaJSExample {
    implicit val ec = ExecutionContext.global


    var drawing="Nothing"
    var secondClick = false
    var rectStore = ArrayBuffer[Double](0,0)
    var color = "black"

    val csrfToken = document.getElementById("csrfToken").asInstanceOf[html.Input].value

    val getShapes = document.getElementById("getShapes").asInstanceOf[html.Input].value
    val uploadShapes = document.getElementById("uploadShape").asInstanceOf[html.Input].value

    val canv = document.getElementById("canvas").asInstanceOf[html.Canvas]
    val ctx = canv.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
    ctx.font = "30px Arial";

  def main(args: Array[String]): Unit = {
        fillCanvWithShapes() 

        $("#draw-line").click{() =>
            drawLine()
        }
        $("#draw-rectangle").click{() =>
            drawRectangle()
        }
        $("#color-white").click{() =>
            color="white"
        }
        $("#color-black").click{() =>
            color="black"
        }
        $("#color-red").click{() =>
            color="red"
        }

        fillCanvWithShapes()



        //uploadShape("L####X")

        canv.addEventListener("click", {(e: dom.MouseEvent) =>
            //println("Clicked on" + e.pageY)
            if(drawing=="Line") {
                println("Drawing a line")
                //ctx.beginPath
                
                //ctx.stroke()
                if(secondClick) {

                    ctx.lineTo(e.pageX-5, e.pageY-80)
                    ctx.stroke()
                    secondClick = false
                    uploadShape(color, drawing, rectStore, ArrayBuffer[Double](e.pageX-5, e.pageY-80))

                } else {
                    ctx.strokeStyle = color
                    ctx.beginPath()
                    rectStore = ArrayBuffer[Double](e.pageX-5, e.pageY-80)
                    ctx.moveTo(e.pageX-5, e.pageY-80)
                    secondClick=true
                }
            } else if (drawing =="Rect") {
                println("Drawing a Rectangle")
                if(secondClick) {
                    ctx.beginPath()
                    ctx.moveTo(rectStore(0), rectStore(1))

                    ctx.lineTo(rectStore(0), e.pageY-80)
                    //ctx.moveTo(rectStore(0), e.pageY-80)
                    ctx.lineTo(e.pageX-5, e.pageY-80)
                    //ctx.moveTo(rectStore(0), e.pageX-5)
                    //ctx.lineTo()
                    ctx.lineTo(e.pageX-5, rectStore(1))
                    ctx.lineTo(rectStore(0), rectStore(1))

                    ctx.stroke()
                    secondClick = false
                    uploadShape(color, drawing, rectStore, ArrayBuffer[Double](e.pageX-5, e.pageY-80))

                } else {
                    ctx.strokeStyle=color
                    //ctx.beginPath()
                    rectStore = ArrayBuffer[Double](e.pageX-5, e.pageY-80)
                    //ctx.moveTo(e.pageX-5, e.pageY-80)
                    secondClick=true

                }

            }
        })






  }

  def drawLine() = {
    //println("Line drawing")
    secondClick=false
    drawing="Line"
  }
  def drawRectangle() = {
    //println("Rectangle drawing")
    secondClick = false
    drawing="Rect"
  }

  def fillCanvWithShapes() {
    println("getting shapes")
    var test = Fetch.fetch(getShapes, RequestInit(method=HttpMethod.GET)).flatMap(res => res.text()).map { data =>
        Json.fromJson[String](Json.parse(data)) match {
            case JsSuccess(string, path) =>
                println(string)
                parseAndDraw(string)
            case e @ JsError(_) =>
                println("no string, error: " + e)
        }
    }


  }

  @JSExportTopLevel("uploadShape")
  def uploadShape(color: String, drawing: String, firstCoords: ArrayBuffer[Double], endCoords: ArrayBuffer[Double]) {
    var parsedShapeData = color + "####" + drawing + "####" + firstCoords(0).toString + "####" + firstCoords(1).toString + "####" + endCoords(0).toString + "####" + endCoords(1).toString
    val headers = new Headers()
    headers.set("Content-Type", "application/json")
    headers.set("Csrf-Token", csrfToken)
    
    Fetch.fetch(uploadShapes, RequestInit(method=HttpMethod.POST, mode=RequestMode.cors,
        headers = headers, body = Json.toJson(parsedShapeData).toString)
        ).flatMap(res => res.text()
        ).map { data =>
            Json.fromJson[Boolean](Json.parse(data)) match {
                case JsSuccess(bool, path) =>
                    if(bool) println("upload success.")
                    else println("upload failed.")
                case e @ JsError(_) =>
                    println("Fetch error: " + e)

            }
        }
  }

  def parseAndDraw(str: String) {
    var parsed = str.split(",")
    for(i <- 0 until parsed.length) {
        println(parsed(i))
        if(i%6 == 0) {
            drawing=parsed(i)
        } else if (i%6==1) {
            color=parsed(i)
        } else if(i%6==2) {
            if(drawing == "Rect") {
                ctx.strokeStyle=color

                ctx.beginPath()
                ctx.moveTo(parsed(i).toInt, parsed(i+1).toInt)

                ctx.lineTo(parsed(i).toInt, parsed(i+3).toInt)
                //ctx.moveTo(rectStore(0), e.pageY-80)
                ctx.lineTo(parsed(i+2).toInt, parsed(i+3).toInt)
                //ctx.moveTo(rectStore(0), e.pageX-5)
                //ctx.lineTo()
                ctx.lineTo(parsed(i+2).toInt, parsed(i+1).toInt)
                ctx.lineTo(parsed(i).toInt, parsed(i+1).toInt)

                ctx.stroke()
            } else {
                ctx.strokeStyle=color

                ctx.beginPath()
                ctx.moveTo(parsed(i).toInt, parsed(i+1).toInt)
                ctx.lineTo(parsed(i+2).toInt, parsed(i+3).toInt)
                ctx.stroke()
            }
        }
    }
  }
  	    

}
