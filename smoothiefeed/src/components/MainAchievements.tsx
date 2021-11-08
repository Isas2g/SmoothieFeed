import React from 'react';
import AchievementsList from "./AchievementsList";

const MainAchievements = () => {
    return (
        <main className="main">
            <div className="container">
                <div className="main__achievements achievements">
                    <h1 className="achievements__title main-title">Достижения</h1>
                    <AchievementsList />
                </div>
            </div>
        </main>
    );
};

export default MainAchievements;