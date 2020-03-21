/*
 * This project is the sole property of Siddharth Mehta. It may not be duplicated or reproduced without my consent. Please direct all technical queries to mehtasiddharth@hotmail.co.uk
 */

package controllers;

import db.DBQueryInterface;
import models.SearchRegion;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.*;

public class SearchResult {

    /**
     *
     * @param queryString
     * @param index
     * @param analyzer
     * @param numResultsToSkip
     * @param numResultsToReturn
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static Set<String> fetchSearchResult(String queryString, Directory index, StandardAnalyzer analyzer, int numResultsToSkip, int numResultsToReturn) throws IOException, ParseException {
        Searcher searcher = new Searcher(index, analyzer);
        ScoreDoc[] hits = searcher.search(queryString);
        int startValue = 0;
        int endValue = hits.length;
        if (numResultsToSkip > hits.length || numResultsToReturn > hits.length) {
            System.out.println("Requested Result Count Exceeds Available Result Count!");
        } else {
            startValue = numResultsToSkip + 1;
            endValue = (numResultsToReturn + numResultsToSkip) >= hits.length ? hits.length : (numResultsToSkip + numResultsToReturn) + 1;
        }
        Set<String> results = new HashSet<>();
        for (int i = startValue; i < endValue; i++) {
            int docId = hits[i].doc;
            Document d = searcher.getIndexSearcher().doc(docId);
            results.add(d.get("title"));
        }
        searcher.close();
        return results;
    }

    /**
     *
     * @param queryString
     * @param searchRegion
     * @param index
     * @param analyzer
     * @param numResultsToSkip
     * @param numResultsToReturn
     * @return
     */
    public static Set<String> fetchSpatialSearchResult(String queryString, SearchRegion searchRegion, Directory index, StandardAnalyzer analyzer, int numResultsToSkip, int numResultsToReturn) {
        try {
            Set<String> titleResults = fetchSearchResult(queryString, index, analyzer, Integer.MAX_VALUE, Integer.MAX_VALUE);
            ResultSet rs = DBQueryInterface.fetchSpatialRegionTitles(searchRegion);
            Set<String> spatialResults = new HashSet<>();
            Set<String> finalResult = new HashSet<String>(titleResults);
            while(rs.next()){
                spatialResults.add(rs.getString("title"));
            }
            finalResult.retainAll(spatialResults);
            int endValue = finalResult.size();
            if (numResultsToSkip > finalResult.size() || numResultsToReturn > finalResult.size()) {
                System.out.println("Requested Result Count Exceeds Available Result Count!");
            } else {
                endValue = numResultsToReturn + 1;
            }
            int i = finalResult.size();
            for (Iterator<String> iterator = finalResult.iterator(); iterator.hasNext();) {
                iterator.next();
                iterator.remove();
                if (i-- == endValue) break;
            }
            return finalResult;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
