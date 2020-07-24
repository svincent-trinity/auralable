package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._
import play.api.i18n._
import models.ShapesInDatabaseModel

import play.api.libs.json._
import models._
import play.api.data._

import play.api.db.slick.DatabaseConfigProvider
import scala.concurrent.ExecutionContext
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Future
import scala.concurrent.duration.Duration


@Singleton
class Application @Inject() (protected val dbConfigProvider: DatabaseConfigProvider, cc: MessagesControllerComponents)(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) with HasDatabaseConfigProvider[JdbcProfile] {


  private val model = new ShapesInDatabaseModel(db)

  def index = Action { implicit request =>

    Ok(views.html.index(SharedMessages.itWorks))
  }

  def withJsonBody[A](f: A => Future[Result])(implicit request: Request[AnyContent], reads: Reads[A]): Future[Result] = {
    request.body.asJson.map {body => 
          Json.fromJson[A](body) match {
              case JsSuccess(a, path) => f(a)
              case e @ JsError(_) => Future.successful(Redirect(routes.Application.index()))
          }
       }.getOrElse(Future.successful(Redirect(routes.Application.index())))

  }


  def getShapes = Action.async { implicit request =>
    model.grabThemShapes().map(shapes => Ok(Json.toJson(shapes.mkString(","))))
    //Future.successful(Ok(Json.toJson("Line,red,13,100,200,100,Rect,black,40,200,250,300")))
  }

  def uploadShape = Action.async { implicit request =>
    withJsonBody[String] { task =>
      var parsed = task.split("####");
        val p2 = parsed(0) +","+ parsed(2) +","+ parsed(3)+","+parsed(4)+","+parsed(5)
        println(parsed(1))
        println(p2)
        //Future.successful(Ok(Json.toJson(true)))
        model.uploadDatShape(parsed(1), p2).map(count => Ok(Json.toJson(count > 0)))
      }

  }
}


