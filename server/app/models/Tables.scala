package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Shapes.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Shapes
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param shape Database column shape SqlType(varchar), Length(8,true)
   *  @param data Database column data SqlType(varchar), Length(200,true) */
  case class ShapesRow(id: Int, shape: String, data: String)
  /** GetResult implicit for fetching ShapesRow objects using plain SQL queries */
  implicit def GetResultShapesRow(implicit e0: GR[Int], e1: GR[String]): GR[ShapesRow] = GR{
    prs => import prs._
    ShapesRow.tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table shapes. Objects of this class serve as prototypes for rows in queries. */
  class Shapes(_tableTag: Tag) extends profile.api.Table[ShapesRow](_tableTag, "shapes") {
    def * = (id, shape, data) <> (ShapesRow.tupled, ShapesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(shape), Rep.Some(data))).shaped.<>({r=>import r._; _1.map(_=> ShapesRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column shape SqlType(varchar), Length(8,true) */
    val shape: Rep[String] = column[String]("shape", O.Length(8,varying=true))
    /** Database column data SqlType(varchar), Length(200,true) */
    val data: Rep[String] = column[String]("data", O.Length(200,varying=true))
  }
  /** Collection-like TableQuery object for table Shapes */
  lazy val Shapes = new TableQuery(tag => new Shapes(tag))
}
