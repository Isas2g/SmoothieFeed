import React            from 'react';
import Header           from '@components/Header/Header';
import AchievementsList from '@components/AchievementsList/AchievementsList';
import MainAchievements from '../components/MainAchievements';

const Achievements = () => {
	return <div className="container-bg-image-social">
		<Header/>
		<MainAchievements/>
	</div>;
};

export default Achievements;