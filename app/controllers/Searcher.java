/*
 * This project is the sole property of Siddharth Mehta. It may not be duplicated or reproduced without my consent. Please direct all technical queries to mehtasiddharth@hotmail.co.uk
 */

package controllers;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.IOException;

public class Searcher {

    IndexSearcher indexSearcher;
    IndexReader reader;
    QueryParser queryParser;
    Query query;
    private static final int HITS_PER_PAGE = 100;

    /**
     *
     * @param index
     * @param analyzer
     * @throws IOException
     */
    public Searcher(Directory index, StandardAnalyzer analyzer) throws IOException {
        reader = DirectoryReader.open(index);
        indexSearcher = new IndexSearcher(reader);
        queryParser = new QueryParser("author", analyzer);
    }

    /**
     *
     * @param searchQuery
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public ScoreDoc[] search(String searchQuery)
            throws IOException, ParseException {
        TopScoreDocCollector collector = TopScoreDocCollector.create(HITS_PER_PAGE);
        query = queryParser.parse(searchQuery);
        indexSearcher.search(query, collector);
        return collector.topDocs().scoreDocs;
    }

    /**
     *
     * @throws IOException
     */
    public void close() throws IOException {
        reader.close();
    }

    /**
     *
     * @return
     */
    public IndexSearcher getIndexSearcher(){
        return indexSearcher;
    }
}
