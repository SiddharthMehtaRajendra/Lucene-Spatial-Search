name := "server"
 
version := "1.0" 
      
lazy val `server` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
resolvers += "Lucene-Core" at "https://mvnrepository.com/artifact/org.apache.lucene/lucene-core"
resolvers += "Lucene-Analyzer" at "https://mvnrepository.com/artifact/org.apache.lucene/lucene-analyzers-common"
resolvers += "Lucene-QueryParser" at "https://mvnrepository.com/artifact/org.apache.lucene/lucene-queryparser"
resolvers += "XQuery" at "https://mvnrepository.com/artifact/org.apache.servicemix.bundles/org.apache.servicemix.bundles.saxon"
scalaVersion := "2.12.2"
libraryDependencies += "org.apache.lucene" % "lucene-analyzers-common" % "5.5.5"
libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )
unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.11"
libraryDependencies += "org.neo4j.driver" % "neo4j-java-driver" % "1.6.4"
libraryDependencies += "org.apache.servicemix.bundles" % "org.apache.servicemix.bundles.saxon" % "9.3.0.11_1"
libraryDependencies += "org.apache.lucene" % "lucene-core" % "5.5.5"
libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.0"
libraryDependencies += "org.apache.lucene" % "lucene-analyzers-common" % "5.5.5"
libraryDependencies += "org.apache.lucene" % "lucene-queryparser" % "5.5.5"
      