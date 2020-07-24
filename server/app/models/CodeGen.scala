package models

object CodeGen extends App {
  slick.codegen.SourceCodeGenerator.run(
    "slick.jdbc.PostgresProfile", 
    "org.postgresql.Driver",
    "jdbc:postgresql://localhost/drawings?user=samvincent&password=password",
    "/Users/samvincent/Desktop/heroku-deploys/Task11/server/app/",
    "models", None, None, true, false
  )
}