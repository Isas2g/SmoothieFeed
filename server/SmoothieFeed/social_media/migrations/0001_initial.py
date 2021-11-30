# Generated by Django 3.2.9 on 2021-11-30 17:32

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='SocialMedia',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=64, unique=True, verbose_name='имя')),
            ],
            options={
                'verbose_name': 'Социальна сеть',
                'verbose_name_plural': 'Социальные сети',
                'db_table': 'API_social_media',
            },
        ),
        migrations.CreateModel(
            name='SocialMediaPublic',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('public_id', models.IntegerField()),
                ('media', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='social_media.socialmedia')),
            ],
            options={
                'verbose_name': 'Паблик из социальной сети',
                'verbose_name_plural': 'Паблики из социальной сети',
                'db_table': 'API_social_media_public',
                'unique_together': {('media', 'public_id')},
            },
        ),
    ]
