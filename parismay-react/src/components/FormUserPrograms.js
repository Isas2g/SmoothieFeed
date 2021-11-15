import React               from 'react';
import CreateProgramButton from "./UI/buttons/CreateProgramButton";

const FormUserPrograms = () => {
    return (
        <form className="main__your-program your-program">
            <h2 className="your-program__title main-title">Или создать свою</h2>
            <div className="your-program__block">
                <div className="your-program__icon">
                    <svg width="70" height="70" viewBox="0 0 93 93" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M46.5 7.75C25.1333 7.75 7.75 25.1333 7.75 46.5C7.75 67.8668 25.1333 85.25 46.5 85.25C67.8668 85.25 85.25 67.8668 85.25 46.5C85.25 25.1333 67.8668 7.75 46.5 7.75ZM46.5 77.5C29.4074 77.5 15.5 63.5926 15.5 46.5C15.5 29.4074 29.4074 15.5 46.5 15.5C63.5926 15.5 77.5 29.4074 77.5 46.5C77.5 63.5926 63.5926 77.5 46.5 77.5Z" fill="black"/>
                        <path d="M50.375 31C50.375 28.8599 48.6401 27.125 46.5 27.125C44.3599 27.125 42.625 28.8599 42.625 31V45.375C42.625 48.1364 44.8636 50.375 47.625 50.375H62C64.1401 50.375 65.875 48.6401 65.875 46.5C65.875 44.3599 64.1401 42.625 62 42.625H55.375C52.6136 42.625 50.375 40.3864 50.375 37.625V31Z" fill="black"/>
                    </svg>
                </div>
                <label className="your-program__post-title" htmlFor="program-time">Выбери время просмотра постов</label>
                <input className="your-program__input" type="text" id="program-time"/>
            </div>
            <div className="your-program__other">
                <hr className="hr-line"/>
                <h4 className="your-program__or main-title">или</h4>
                <hr className="hr-line"/>
            </div>
            <div className="your-program__block">
                <div className="your-program__icon">
                    <svg width="70" height="70" viewBox="0 0 77 77" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M51.3333 57.75C51.3333 59.5219 49.8969 60.9584 48.125 60.9584H12.8333C11.0614 60.9584 9.625 59.5219 9.625 57.75C9.625 55.9781 11.0614 54.5417 12.8333 54.5417H48.125C49.8969 54.5417 51.3333 55.9781 51.3333 57.75ZM67.375 32.0834C67.375 30.3114 65.9386 28.875 64.1667 28.875H12.8333C11.0614 28.875 9.625 30.3114 9.625 32.0834C9.625 33.8553 11.0614 35.2917 12.8333 35.2917H64.1667C65.9386 35.2917 67.375 33.8553 67.375 32.0834ZM12.8333 16.0417C11.0614 16.0417 9.625 17.4781 9.625 19.25C9.625 21.0219 11.0614 22.4584 12.8333 22.4584H41.7083C43.4802 22.4584 44.9167 21.0219 44.9167 19.25C44.9167 17.4781 43.4802 16.0417 41.7083 16.0417H12.8333ZM57.75 16.0417C55.9781 16.0417 54.5417 17.4781 54.5417 19.25C54.5417 21.0219 55.9781 22.4584 57.75 22.4584H64.1667C65.9386 22.4584 67.375 21.0219 67.375 19.25C67.375 17.4781 65.9386 16.0417 64.1667 16.0417H57.75ZM38.5 41.7084C36.7281 41.7084 35.2917 43.1448 35.2917 44.9167C35.2917 46.6886 36.7281 48.125 38.5 48.125H64.1667C65.9386 48.125 67.375 46.6886 67.375 44.9167C67.375 43.1448 65.9386 41.7084 64.1667 41.7084H38.5ZM12.8333 41.7084C11.0614 41.7084 9.625 43.1448 9.625 44.9167C9.625 46.6886 11.0614 48.125 12.8333 48.125H22.4583C24.2302 48.125 25.6667 46.6886 25.6667 44.9167C25.6667 43.1448 24.2302 41.7084 22.4583 41.7084H12.8333Z" fill="black"/>
                    </svg>

                </div>
                <label className="your-program__post-title" htmlFor="program-count">Выбери количество постов в день</label>
                <input className="your-program__input" type="text" id="program-count"/>
            </div>
            <div className="your-program__submit">
                <CreateProgramButton />
            </div>
        </form>
    );
};

export default FormUserPrograms;