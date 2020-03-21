/*
 * This project is the sole property of Siddharth Mehta. It may not be duplicated or reproduced without my consent. Please direct all technical queries to mehtasiddharth@hotmail.co.uk
 */

package controllers;

import db.DBQueryInterface;
import models.PublicationRecord;
import models.SearchRegion;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.*;

public class PublicationSearch extends Controller {

    public Result index() {
        return ok(Json.toJson("Welcome to backend!"));
    }

    private static List<PublicationRecord> publicationRecords = retrievePublications();
    private StandardAnalyzer analyzer;
    private Directory index;
    private IndexWriterConfig config;
    private IndexWriter writer;

    /**
     * Constructor to Initialize Objects
     */
    public PublicationSearch(){
        try {
            analyzer = new StandardAnalyzer();
            index = new RAMDirectory();
            config = new IndexWriterConfig(analyzer);
            writer = new IndexWriter(index, config);
            for (PublicationRecord record : publicationRecords) {
                addDocumentToIndex(writer, record.getPublicationTitle(), record.getAuthorName());
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            try {
                writer.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param w
     * @param title
     * @param author
     */
    private static void addDocumentToIndex(IndexWriter w, String title, String author){
        try {
            Document doc = new Document();
            doc.add(new TextField("title", title, Field.Store.YES));
            doc.add(new TextField("author", author, Field.Store.YES));
            w.addDocument(doc);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Fetch Publications to Add to Index
     * @return
     */
    private static List<PublicationRecord> retrievePublications() {
        try {
            ResultSet rs = DBQueryInterface.fetchPublicationsAndAuthors();
            List<PublicationRecord> records = new ArrayList<>();
            if (rs != null) {
                while (rs.next()) {
                    PublicationRecord publicationRecord = new PublicationRecord();
                    publicationRecord.setPublicationTitle(rs.getString("title"));
                    publicationRecord.setAuthorName(rs.getString("author_name"));
                    records.add(publicationRecord);
                }
            }
            return records;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Basic Lucene Search
     * @param query
     * @param numResultsToSkip
     * @param numResultsToReturn
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public Result basicSearch(String query, int numResultsToSkip, int numResultsToReturn) throws IOException, ParseException {
        String queryString = "title:" + "(" + query + ")" + " OR author:" + "(" + query + ")";
        Set<String> results = SearchResult.fetchSearchResult(queryString, index, analyzer, numResultsToSkip, numResultsToReturn);
        return ok(Json.toJson(results));
    }

    /**
     * Spatial Search integrated with Lucene Search
     * @param query
     * @param yearFrom
     * @param yearTo
     * @param numResultsToSkip
     * @param numResultsToReturn
     * @return
     */
    public Result spatialSearch(String query, Integer yearFrom, Integer yearTo, int numResultsToSkip, int numResultsToReturn) {
        String queryString = "title:" + "(" + query + ")" + " OR author:" + "(" + query + ")";
        SearchRegion searchRegion = new SearchRegion();
        searchRegion.setSource(yearFrom - 1, 1);
        searchRegion.setDestination(yearTo + 1, 1);
        Set<String> results = SearchResult.fetchSpatialSearchResult(queryString, searchRegion, index, analyzer, numResultsToSkip, numResultsToReturn);
        return ok(Json.toJson(results));
    }

}
