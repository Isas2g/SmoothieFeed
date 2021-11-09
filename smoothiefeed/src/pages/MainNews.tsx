import React from 'react';
import Header from '../components/Header'
import TomorrowButton from "../components/UI/buttons/TomorrowButton";
import FilterSocial from "../components/FilterSocial";
import PostsNews from "../components/PostsNews";

const MainNews = () => {
    return (
        <div>
            <Header />
            <main className="main">
                <div className="main__news news">
                    <div className="container--lg">
                        <h1 className="news__title main-title">Новости</h1>
                        <div className="news__inner">

                            <FilterSocial />
                            <PostsNews />

                        </div>
                        <div className="news__tomorrow-button">
                            <TomorrowButton />
                        </div>

                    </div>

                </div>
            </main>
        </div>

    );
};

export default MainNews;