package controllers

import models.tables._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc._
import slick.jdbc.JdbcProfile
import slick.lifted

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}


@Singleton
class HomeController @Inject() (protected val dbConfigProvider: DatabaseConfigProvider, cc: ControllerComponents)(
  implicit ec: ExecutionContext
) extends AbstractController(cc)
  with HasDatabaseConfigProvider[JdbcProfile] {

  def index: Action[AnyContent] = Action.async { implicit request =>
    import dbConfig.profile.api._
    val tuser = lifted.TableQuery[UserTables]
    val query = for (u <- tuser) yield (u.id, u.name, u.email)
    val rstuser: Future[Seq[(Int, String, String)]] = db.run(query.result)

    rstuser.map {
      users => {println(users)
        Ok(views.html.index())
      }
    }
  }
}
