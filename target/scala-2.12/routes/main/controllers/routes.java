// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/siddharthmehta/Desktop/Carnegie Mellon University Material/18-655 Service Oriented Computing/Homework 3/Backend/conf/routes
// @DATE:Fri Feb 28 22:26:50 PST 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReversePublicationSearch PublicationSearch = new controllers.ReversePublicationSearch(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReversePublicationSearch PublicationSearch = new controllers.javascript.ReversePublicationSearch(RoutesPrefix.byNamePrefix());
  }

}
