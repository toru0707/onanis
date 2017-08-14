package com.onanis.crw.webclient;

import com.gargoylesoftware.htmlunit.WebClient;
import com.onanis.crw.entity.SiteMovie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractWebClient {

    protected WebClient webClient;

    private Date lastMovieUploadDate;

    private boolean isFirstPage;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public AbstractWebClient(Date lastMovieUploadDate){
        this.webClient = new WebClient();
        this.lastMovieUploadDate = lastMovieUploadDate;
        this.isFirstPage = true;
    }

    public void crawl() throws Exception{
        try {
            // move to indexPage
            webClient.getPage(indexPageUrl());

            // search
            prepareForSearch();
            search();

            // list detailPage
            List<SiteMovie> movies = new ArrayList<>();
            do {
                if(!this.isFirstPage){
                    webClient.getPage(handleNextPage());
                }
                prepareForListDetailPageUrls();
                for (String url:listDetailPageUrls()) {
                    // move to detailPage
                    webClient.getPage(url);
                    SiteMovie siteMovie = SiteMovie.builder().url(url).siteId(handleSiteId()).innerHtml(handleInnerHtml())
                            .title(handleTitle()).actors(handleActors()).tags(handleTags())
                            .playTime(handlePlayTime()).goodNum(handleGoodNum()).badNum(handleBadNum())
                            .favoriteNum(handleFavoriteNum()).viewedNum(handleViewedNum()).uploadedDate(handleUploadedDate())
                            .build();
                    // ダウンロードしたMovieより古い動画が出てきたらクロールを中止

                    // 動画を格納対象に追加
                    movies.add(siteMovie);
                }
                // 初期ページのクロールが完了したことを設定
                this.isFirstPage = false;
            }while (nextPageLimit() <= handleCurrentPage());

        }catch (Exception e){
            logger.error(e.getMessage(), e.getCause());
            throw e;
        }
    }


    // インデックスページURL
    protected abstract String indexPageUrl();

    // 検索処理
    protected void prepareForSearch(){
        return;
    }

    protected abstract void search();

    // 動画URL一覧取得
    protected abstract void prepareForListDetailPageUrls();

    protected abstract List<String> listDetailPageUrls();

    // 動画詳細情報取得
    protected abstract Date handleUploadedDate();

    protected abstract int handleViewedNum();

    protected abstract int handleFavoriteNum();

    protected abstract int handleBadNum();

    protected abstract int handleGoodNum();

    protected abstract Date handlePlayTime();

    protected abstract List<String> handleTags();

    protected abstract List<String> handleActors();

    protected abstract String handleTitle();

    protected abstract String handleInnerHtml();

    protected abstract String handleSiteId();

    // 次ページ移動
    protected abstract String handleNextPage();

    protected abstract int nextPageLimit();

    protected abstract int handleCurrentPage();
}
