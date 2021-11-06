import React from 'react';
import Header from '../components/Header'

const MainNews = () => {
    return (
        <div>
            <Header />
            <main className="main">
                <div className="main__news news">
                    <div className="container--lg">
                        <h1 className="news__title main-title">Новости</h1>
                        <div className="news__inner">
                            <div className="news__filter filter">123</div>
                            <div className="news__posts">
                                <div className="news__post post">
                                    <div className="post__header">
                                        <div className="post__public-icon"></div>
                                        <div className="post__info">
                                            <h3 className="post__public-title">Название паблика</h3>
                                            <h6 className="post__public-time">Время поста</h6>
                                        </div>
                                    </div>
                                    <div className="post__body">

                                    </div>
                                </div>
                                <div className="news__post post">
                                    <div className="post__header">
                                        <div className="post__public-icon"></div>
                                        <div className="post__info">
                                            <h3 className="post__public-title">Название паблика</h3>
                                            <h6 className="post__public-time">Время поста</h6>
                                        </div>
                                    </div>
                                    <div className="post__body">

                                    </div>
                                </div>
                                <div className="news__post post">
                                    <div className="post__header">
                                        <div className="post__public-icon"></div>
                                        <div className="post__info">
                                            <h3 className="post__public-title">Название паблика</h3>
                                            <h6 className="post__public-time">Время поста</h6>
                                        </div>
                                    </div>
                                    <div className="post__body">

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="news__tomorrow-button">
                            <button className="tomorrow-button">Количество постов ограничено. Возвращайся
                                завтра!
                            </button>
                        </div>

                    </div>

                </div>
            </main>
        </div>

    );
};

export default MainNews;