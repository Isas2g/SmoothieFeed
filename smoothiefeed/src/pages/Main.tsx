import React from 'react';
import Header from "../components/Header";

const Main = () => {
    return (
        <div>
            <Header />
            <main className="main">
                <div className="container-bg-image-social">
                    <div className="container-bg-image-kiwi">
                        <div className="container">
                            <div className="main__preview preview">
                                <h1 className="preview__title">Заголовок</h1>
                                <h3 className="preview__description">Выбери уже существующую программу digital-детокса или
                                    создай свою!</h3>
                                <button className="preview__button learn-button">Ознакомиться</button>
                            </div>
                        </div>
                    </div>
                </div>
                <hr className="hr-line" />
                <div className="container-bg-image-smoothie-social">
                    <div className="container">
                        <div className="main__how-it-works how-it-works">
                            <h2 className="how-it-works__title main-title">Как это работает?</h2>
                            <div className="how-it-works__blocks">
                                <div className="how-it-works__block">
                                    <div className="how-it-works__icon">
                                        <svg width="32" height="40" viewBox="0 0 42 52" fill="none"
                                             xmlns="http://www.w3.org/2000/svg">
                                            <path
                                                d="M19.439 33.9743C19.1202 34.3451 18.9438 34.8418 18.9478 35.3574C18.9518 35.873 19.1359 36.3662 19.4603 36.7307C19.7848 37.0953 20.2237 37.3021 20.6825 37.3066C21.1414 37.3111 21.5834 37.1129 21.9135 36.7547L31.248 26.2269C31.3295 26.1356 31.3941 26.0271 31.4382 25.9077C31.4824 25.7882 31.5051 25.6602 31.5051 25.5309C31.5051 25.4015 31.4824 25.2735 31.4382 25.154C31.3941 25.0346 31.3295 24.9261 31.248 24.8348L21.9135 14.311C21.5834 13.9528 21.1414 13.7546 20.6825 13.7591C20.2237 13.7635 19.7848 13.9703 19.4603 14.3349C19.1359 14.6995 18.9518 15.1927 18.9478 15.7082C18.9438 16.2238 19.1202 16.7205 19.439 17.0914L25.2 23.596H1.75C1.28587 23.596 0.840752 23.8032 0.512563 24.1719C0.184374 24.5407 0 25.0408 0 25.5623C0 26.0838 0.184374 26.584 0.512563 26.9527C0.840752 27.3215 1.28587 27.5286 1.75 27.5286H25.2L19.439 33.9743ZM38.5 0H15.75C15.2859 0 14.8408 0.207166 14.5126 0.575925C14.1844 0.944684 14 1.44483 14 1.96633C14 2.48784 14.1844 2.98798 14.5126 3.35674C14.8408 3.7255 15.2859 3.93266 15.75 3.93266H36.75C37.2141 3.93266 37.6592 4.13983 37.9874 4.50859C38.3156 4.87735 38.5 5.37749 38.5 5.899V45.2256C38.5 45.7471 38.3156 46.2473 37.9874 46.616C37.6592 46.9848 37.2141 47.192 36.75 47.192H14.875C14.4109 47.192 13.9658 47.3991 13.6376 47.7679C13.3094 48.1367 13.125 48.6368 13.125 49.1583C13.125 49.6798 13.3094 50.18 13.6376 50.5487C13.9658 50.9175 14.4109 51.1246 14.875 51.1246H38.5C39.4283 51.1246 40.3185 50.7103 40.9749 49.9728C41.6312 49.2353 42 48.235 42 47.192V3.93266C42 2.88966 41.6312 1.88937 40.9749 1.15185C40.3185 0.414333 39.4283 0 38.5 0Z"
                                                fill="black"/>
                                        </svg>
                                    </div>
                                    <div className="how-it-works__text">
                                        <h4 className="how-it-works__post-title">1. Регистрация/вход</h4>
                                        <h5 className="how-it-works__description">Зарегистрируйся или выполни вход через
                                            соцсети
                                        </h5>
                                    </div>
                                </div>
                                <div className="how-it-works__block">
                                    <div className="how-it-works__icon">
                                        <svg width="40" height="40" viewBox="0 0 50 49" fill="none"
                                             xmlns="http://www.w3.org/2000/svg">
                                            <path
                                                d="M38.1667 16.3333C38.1667 16.3333 32.4792 10.1666 24.9896 16.3333C17.5 22.5 10.8958 19.5 10.8958 13C10.8958 6.5 10.8958 8.16665 10.8958 8.16665H39.1042L38.1667 16.3333ZM6.25 4.08331L10.4167 41.3029C10.6875 43.3446 12.4375 44.9166 14.5833 44.9166H35.4167C37.5 44.9166 39.3125 43.3446 39.5833 41.3029L43.75 4.08331H6.25Z"
                                                fill="black"/>
                                        </svg>

                                    </div>
                                    <div className="how-it-works__text">
                                        <h4 className="how-it-works__post-title">2. Подбор подходящей программы
                                            digital-детокса
                                        </h4>
                                        <h5 className="how-it-works__description">Ограничь время и количество постов в
                                            день
                                            из
                                            выбранных соцсетей
                                        </h5>
                                    </div>
                                </div>
                                <div className="how-it-works__block">
                                    <div className="how-it-works__icon">
                                        <svg width="40" height="40" viewBox="0 0 56 56" fill="none"
                                             xmlns="http://www.w3.org/2000/svg">
                                            <path
                                                d="M30.3333 4.73669C30.3333 4.73669 28.5 8.45027 30.3333 9.45003C31.2698 9.96071 36.4351 10.5667 41 15.5C45.5649 20.4333 47.2712 25.1611 46.5733 30.2634C45.1466 40.6934 35.5 46.6667 30.3333 46.5034C25.1666 46.34 30.3333 51.17 30.3333 51.17C43.1667 49.8867 52.5 38.5 51.2167 25.6667C50.1667 14.5834 41.37 5.83336 30.3333 4.73669ZM25.6667 4.80669C21.1166 5.25003 13.1833 7.88006 13.23 9.94003C13.2767 12 15.7733 14.2867 16.5667 13.3934C17.36 12.5 22.33 9.94003 25.6667 9.47336V4.80669ZM9.93998 13.23C8.5 13.3934 3 25 4.78332 25.6667C6.56664 26.3334 9.44998 25.6667 9.44998 25.6667C9.89332 22.3534 11.2 19.2034 13.2767 16.5667C13.2767 16.5667 11.38 13.0667 9.93998 13.23ZM36.1667 19.8334C35 20.5 26.06 30.9401 24.78 31.22C23.5 31.5 21.1666 27.5467 19.8333 26.2734C18.5 25 16.5667 27 17.36 28.7467C18.1533 30.4934 24.78 36.6667 25.6667 36C26.5533 35.3333 37.5 23 38.64 22.3067C39.78 21.6134 37.3333 19.1667 36.1667 19.8334ZM4.80665 30.3334C3.6133 30.4034 7.06998 39.2234 9.96332 42.77C9.96332 42.77 14.5066 40.4334 13.23 39.5C11.9533 38.5666 9.47332 30.3334 9.47332 30.3334C9.47332 30.3334 6 30.2634 4.80665 30.3334ZM16.5667 42.8634C15.5 42.77 13.23 45 13.23 46.06C13.23 47.12 23.5 51.17 25.6667 51.3334C27.8333 51.4967 25.6667 46.6667 25.6667 46.6667C25.6667 46.6667 17.6333 42.9567 16.5667 42.8634Z"
                                                fill="black"/>
                                        </svg>
                                    </div>
                                    <div className="how-it-works__text">
                                        <h4 className="how-it-works__post-title">3. Просмотр постов</h4>
                                        <h5 className="how-it-works__description">Просматривай посты и отслеживай свой
                                            прогресс!
                                        </h5>
                                    </div>
                                </div>
                            </div>
                            <div className="how-it-works__button">
                                <button className="learn-button">Ознакомиться</button>
                            </div>
                        </div>
                    </div>
                </div>
                <hr className="hr-line" />
                <div className="container-bg-image-smoothie">
                    <div className="container-bg-image-strawberry">
                        <div className="container-bg-image-banana">
                            <div className="detox-program">
                                <div className="container">
                                    <div className="detox-program__inner">
                                        <h2 className="detox-program__title">Программы digital-детокса</h2>
                                        <div className="detox-program__blocks">
                                            <a className="detox-program__block easy-program" href="#">
                                                <div className="detox-program__block-title">
                                                    <svg width="25" height="40" viewBox="0 0 25 40" fill="none"
                                                         xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M0 0L3.33333 39.7637H21.6667L25 0H0ZM3.66667 3.97637H21.3333L20.8333 10.3982C15.3 12.9232 13.0833 11.273 12.3 10.5573C11.8833 10.1795 11.2833 9.32458 10.1833 8.72813C9.08333 8.11179 7.58333 7.95273 5.83333 8.58895C5.15 8.80765 4.61667 9.16553 4.16667 9.5234L3.66667 3.97637ZM8.1 12.1478C8.41667 12.1478 8.6 12.2273 8.78333 12.3267C9.16667 12.5256 9.51667 13.0226 10.2833 13.7185C11.7167 15.0307 15.05 16.6212 20.4333 14.7324L18.6667 35.7873H6.33333L4.51667 14.0366C4.6 13.9173 4.85 13.6986 5.28333 13.3407C5.83333 12.9232 6.51667 12.4858 6.66667 12.4261H6.71667C7.35 12.2074 7.78333 12.1279 8.1 12.1478Z"
                                                            fill="black"/>
                                                    </svg>
                                                    <h4 className="detox-program__post-title">easy</h4>
                                                    <svg width="25" height="40" viewBox="0 0 25 40" fill="none"
                                                         xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M0 0L3.33333 39.7637H21.6667L25 0H0ZM3.66667 3.97637H21.3333L20.8333 10.3982C15.3 12.9232 13.0833 11.273 12.3 10.5573C11.8833 10.1795 11.2833 9.32458 10.1833 8.72813C9.08333 8.11179 7.58333 7.95273 5.83333 8.58895C5.15 8.80765 4.61667 9.16553 4.16667 9.5234L3.66667 3.97637ZM8.1 12.1478C8.41667 12.1478 8.6 12.2273 8.78333 12.3267C9.16667 12.5256 9.51667 13.0226 10.2833 13.7185C11.7167 15.0307 15.05 16.6212 20.4333 14.7324L18.6667 35.7873H6.33333L4.51667 14.0366C4.6 13.9173 4.85 13.6986 5.28333 13.3407C5.83333 12.9232 6.51667 12.4858 6.66667 12.4261H6.71667C7.35 12.2074 7.78333 12.1279 8.1 12.1478Z"
                                                            fill="black"/>
                                                    </svg>
                                                </div>
                                                <div className="detox-program__image">
                                                    <img src="./img/easy-cocktail.png" alt="cocktail" />
                                                </div>
                                            </a>
                                            <a className="detox-program__block medium-program" href="#">
                                                <div className="detox-program__block-title">
                                                    <svg width="25" height="40" viewBox="0 0 25 40" fill="none"
                                                         xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M0 0L3.33333 39.7637H21.6667L25 0H0ZM3.66667 3.97637H21.3333L20.8333 10.3982C15.3 12.9232 13.0833 11.273 12.3 10.5573C11.8833 10.1795 11.2833 9.32458 10.1833 8.72813C9.08333 8.11179 7.58333 7.95273 5.83333 8.58895C5.15 8.80765 4.61667 9.16553 4.16667 9.5234L3.66667 3.97637ZM8.1 12.1478C8.41667 12.1478 8.6 12.2273 8.78333 12.3267C9.16667 12.5256 9.51667 13.0226 10.2833 13.7185C11.7167 15.0307 15.05 16.6212 20.4333 14.7324L18.6667 35.7873H6.33333L4.51667 14.0366C4.6 13.9173 4.85 13.6986 5.28333 13.3407C5.83333 12.9232 6.51667 12.4858 6.66667 12.4261H6.71667C7.35 12.2074 7.78333 12.1279 8.1 12.1478Z"
                                                            fill="black"/>
                                                    </svg>
                                                    <h4 className="detox-program__post-title">medium</h4>
                                                    <svg width="25" height="40" viewBox="0 0 25 40" fill="none"
                                                         xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M0 0L3.33333 39.7637H21.6667L25 0H0ZM3.66667 3.97637H21.3333L20.8333 10.3982C15.3 12.9232 13.0833 11.273 12.3 10.5573C11.8833 10.1795 11.2833 9.32458 10.1833 8.72813C9.08333 8.11179 7.58333 7.95273 5.83333 8.58895C5.15 8.80765 4.61667 9.16553 4.16667 9.5234L3.66667 3.97637ZM8.1 12.1478C8.41667 12.1478 8.6 12.2273 8.78333 12.3267C9.16667 12.5256 9.51667 13.0226 10.2833 13.7185C11.7167 15.0307 15.05 16.6212 20.4333 14.7324L18.6667 35.7873H6.33333L4.51667 14.0366C4.6 13.9173 4.85 13.6986 5.28333 13.3407C5.83333 12.9232 6.51667 12.4858 6.66667 12.4261H6.71667C7.35 12.2074 7.78333 12.1279 8.1 12.1478Z"
                                                            fill="black"/>
                                                    </svg>
                                                </div>
                                                <div className="detox-program__image">
                                                    <img src="./img/easy-cocktail.png" alt="cocktail" />
                                                </div>
                                            </a>
                                            <a className="detox-program__block hard-program" href="#">
                                                <div className="detox-program__block-title">
                                                    <svg width="25" height="40" viewBox="0 0 25 40" fill="none"
                                                         xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M0 0L3.33333 39.7637H21.6667L25 0H0ZM3.66667 3.97637H21.3333L20.8333 10.3982C15.3 12.9232 13.0833 11.273 12.3 10.5573C11.8833 10.1795 11.2833 9.32458 10.1833 8.72813C9.08333 8.11179 7.58333 7.95273 5.83333 8.58895C5.15 8.80765 4.61667 9.16553 4.16667 9.5234L3.66667 3.97637ZM8.1 12.1478C8.41667 12.1478 8.6 12.2273 8.78333 12.3267C9.16667 12.5256 9.51667 13.0226 10.2833 13.7185C11.7167 15.0307 15.05 16.6212 20.4333 14.7324L18.6667 35.7873H6.33333L4.51667 14.0366C4.6 13.9173 4.85 13.6986 5.28333 13.3407C5.83333 12.9232 6.51667 12.4858 6.66667 12.4261H6.71667C7.35 12.2074 7.78333 12.1279 8.1 12.1478Z"
                                                            fill="black"/>
                                                    </svg>
                                                    <h4 className="detox-program__post-title">hard</h4>
                                                    <svg width="25" height="40" viewBox="0 0 25 40" fill="none"
                                                         xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                            d="M0 0L3.33333 39.7637H21.6667L25 0H0ZM3.66667 3.97637H21.3333L20.8333 10.3982C15.3 12.9232 13.0833 11.273 12.3 10.5573C11.8833 10.1795 11.2833 9.32458 10.1833 8.72813C9.08333 8.11179 7.58333 7.95273 5.83333 8.58895C5.15 8.80765 4.61667 9.16553 4.16667 9.5234L3.66667 3.97637ZM8.1 12.1478C8.41667 12.1478 8.6 12.2273 8.78333 12.3267C9.16667 12.5256 9.51667 13.0226 10.2833 13.7185C11.7167 15.0307 15.05 16.6212 20.4333 14.7324L18.6667 35.7873H6.33333L4.51667 14.0366C4.6 13.9173 4.85 13.6986 5.28333 13.3407C5.83333 12.9232 6.51667 12.4858 6.66667 12.4261H6.71667C7.35 12.2074 7.78333 12.1279 8.1 12.1478Z"
                                                            fill="black"/>
                                                    </svg>
                                                </div>
                                                <div className="detox-program__image">
                                                    <img src="./img/easy-cocktail.png" alt="cocktail" />
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr className="hr-line" />
                <div className="reviews">
                    <div className="container--lg">
                        <h2 className="reviews__title main-title">Отзывы</h2>
                        <div className="reviews__review review">
                            <div className="review__image"></div>
                            <div className="review__info">
                                <h4 className="review__name">Имя пользователя</h4>
                                <h6 className="review__time">Время</h6>
                                <h5 className="review__text">Классный детокс!</h5>
                            </div>
                            <div className="review__score">
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                            </div>
                        </div>
                        <div className="reviews__review review">
                            <div className="review__image"></div>
                            <div className="review__info">
                                <h4 className="review__name">Имя пользователя</h4>
                                <h6 className="review__time">Время</h6>
                                <h5 className="review__text">Приложение помогло ограничить время, проведённое в
                                    соцсетях</h5>
                            </div>
                            <div className="review__score">
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                            </div>
                        </div>
                        <div className="reviews__review review">
                            <div className="review__image"></div>
                            <div className="review__info">
                                <h4 className="review__name">Имя пользователя</h4>
                                <h6 className="review__time">Время</h6>
                                <h5 className="review__text">Однозначно рекомендую!</h5>
                            </div>
                            <div className="review__score">
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                                <svg width="40" height="37" viewBox="0 0 40 37" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M20 0L24.4903 13.8197H39.0211L27.2654 22.3607L31.7557 36.1803L20 27.6393L8.2443 36.1803L12.7346 22.3607L0.97887 13.8197H15.5097L20 0Z"
                                        fill="#EEC227"/>
                                </svg>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>

    );
};

export default Main;