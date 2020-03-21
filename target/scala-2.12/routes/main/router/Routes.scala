// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/siddharthmehta/Desktop/Carnegie Mellon University Material/18-655 Service Oriented Computing/Homework 3/Backend/conf/routes
// @DATE:Fri Feb 28 22:26:50 PST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  PublicationSearch_0: controllers.PublicationSearch,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    PublicationSearch_0: controllers.PublicationSearch
  ) = this(errorHandler, PublicationSearch_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PublicationSearch_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.PublicationSearch.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """basicSearch""", """controllers.PublicationSearch.basicSearch(query:String, numResultsToSkip:Integer, numResultsToReturn:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """spatialSearch""", """controllers.PublicationSearch.spatialSearch(query:String, yearFrom:Integer, yearTo:Integer, numResultsToSkip:Integer, numResultsToReturn:Integer)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_PublicationSearch_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_PublicationSearch_index0_invoker = createInvoker(
    PublicationSearch_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PublicationSearch",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_PublicationSearch_basicSearch1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("basicSearch")))
  )
  private[this] lazy val controllers_PublicationSearch_basicSearch1_invoker = createInvoker(
    PublicationSearch_0.basicSearch(fakeValue[String], fakeValue[Integer], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PublicationSearch",
      "basicSearch",
      Seq(classOf[String], classOf[Integer], classOf[Integer]),
      "GET",
      this.prefix + """basicSearch""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_PublicationSearch_spatialSearch2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("spatialSearch")))
  )
  private[this] lazy val controllers_PublicationSearch_spatialSearch2_invoker = createInvoker(
    PublicationSearch_0.spatialSearch(fakeValue[String], fakeValue[Integer], fakeValue[Integer], fakeValue[Integer], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PublicationSearch",
      "spatialSearch",
      Seq(classOf[String], classOf[Integer], classOf[Integer], classOf[Integer], classOf[Integer]),
      "GET",
      this.prefix + """spatialSearch""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_PublicationSearch_index0_route(params@_) =>
      call { 
        controllers_PublicationSearch_index0_invoker.call(PublicationSearch_0.index)
      }
  
    // @LINE:9
    case controllers_PublicationSearch_basicSearch1_route(params@_) =>
      call(params.fromQuery[String]("query", None), params.fromQuery[Integer]("numResultsToSkip", None), params.fromQuery[Integer]("numResultsToReturn", None)) { (query, numResultsToSkip, numResultsToReturn) =>
        controllers_PublicationSearch_basicSearch1_invoker.call(PublicationSearch_0.basicSearch(query, numResultsToSkip, numResultsToReturn))
      }
  
    // @LINE:11
    case controllers_PublicationSearch_spatialSearch2_route(params@_) =>
      call(params.fromQuery[String]("query", None), params.fromQuery[Integer]("yearFrom", None), params.fromQuery[Integer]("yearTo", None), params.fromQuery[Integer]("numResultsToSkip", None), params.fromQuery[Integer]("numResultsToReturn", None)) { (query, yearFrom, yearTo, numResultsToSkip, numResultsToReturn) =>
        controllers_PublicationSearch_spatialSearch2_invoker.call(PublicationSearch_0.spatialSearch(query, yearFrom, yearTo, numResultsToSkip, numResultsToReturn))
      }
  }
}
