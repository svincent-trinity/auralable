package models

import slick.jdbc.PostgresProfile.api._
import slick.jdbc.JdbcActionComponent
import scala.concurrent.ExecutionContext
import models.Tables._
import scala.concurrent.Future
import org.mindrot.jbcrypt.BCrypt
import scala.concurrent.duration.Duration
import scala.Option



class ShapesInDatabaseModel(db: Database)(implicit ec: ExecutionContext) {

    def grabThemShapes():Future[Seq[String]] = {
    	db.run(
            (for {
                shape <- Shapes
            } yield {
                shape
            }).result
    	).map(shs => shs.map(sh => sh.shape + "," + sh.data))
    }

    def uploadDatShape(shape: String, data: String):Future[Int] = {
        db.run(Shapes += ShapesRow(-1, shape, data))
    }
}
