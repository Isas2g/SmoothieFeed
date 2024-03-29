# Generated by Django 3.2.9 on 2021-11-30 17:32

import datetime
from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('social_media', '0001_initial'),
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
    ]

    operations = [
        migrations.CreateModel(
            name='UserSources',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('last_seen', models.DateTimeField(auto_now=True)),
                ('total_seen_post', models.IntegerField(default=0)),
                ('total_seen_time', models.DurationField(default=datetime.timedelta(0))),
                ('user', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to=settings.AUTH_USER_MODEL)),
            ],
            options={
                'verbose_name': 'Пользовательские ресурсы',
                'verbose_name_plural': 'Пользовательские ресурсы',
                'db_table': 'API_user_sources',
            },
        ),
        migrations.CreateModel(
            name='UserSettings',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('detox_limit_post', models.IntegerField(default=0)),
                ('detox_limit_time', models.DurationField(default=datetime.timedelta(0))),
                ('user', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to=settings.AUTH_USER_MODEL)),
            ],
            options={
                'verbose_name': 'Пользовательская настройка',
                'verbose_name_plural': 'Пользовательские настройки',
                'db_table': 'API_user_settings',
            },
        ),
        migrations.CreateModel(
            name='UserUseSocialMedia',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('token', models.CharField(max_length=100, unique=True)),
                ('media', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='social_media.socialmedia')),
                ('user', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to=settings.AUTH_USER_MODEL)),
            ],
            options={
                'verbose_name': 'Юзер использует социальные сети',
                'verbose_name_plural': 'Юзеры используют социальные сети',
                'db_table': 'API_user_use_social_media',
                'unique_together': {('user', 'media')},
            },
        ),
        migrations.CreateModel(
            name='Subscribes',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('public', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='social_media.socialmediapublic')),
                ('user', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to=settings.AUTH_USER_MODEL)),
            ],
            options={
                'verbose_name': 'Подписка',
                'verbose_name_plural': 'Подписки',
                'db_table': 'API_subscribes',
                'unique_together': {('user', 'public')},
            },
        ),
    ]
