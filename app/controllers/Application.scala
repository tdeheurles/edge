package controllers

import play.api.libs.json._
import play.api.mvc._

import scalaj.http.{Http, HttpResponse}
import scala.util.{Try, Success, Failure}

object Application extends Controller {

  def Message(ask: String) = Action {

    val triedHttpResponse: Try[HttpResponse[String]] =
      Try(Http("http://backend0:2500/").asString)

    implicit val myCustomCharset = Codec.javaSupported("UTF-8")

    triedHttpResponse match {
      case Success(response) =>
        Ok(Json.toJson(
          Map(
            "status" -> "ok",
            "message" -> s"hello $ask",
            "backend" -> s"${response.body}")
        )).as(HTML)

      case Failure(ex) =>
        Ok(Json.toJson(
          Map(
            "status" -> "error",
            "message" -> s"hello $ask")
        )).as(HTML)
    }
  }
}
