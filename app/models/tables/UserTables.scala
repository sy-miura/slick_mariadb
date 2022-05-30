package models.tables

import models.User
import slick.jdbc.MySQLProfile.api._

class UserTables(tag: Tag) extends Table[User](tag, _tableName="users"){
  def id: Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name: Rep[String] = column[String]("name")
  def email: Rep[String] = column[String]("email")
  //def * = (id, name, email)
  def * = (id.?, name, email) <> (User.tupled,User.unapply)
}

