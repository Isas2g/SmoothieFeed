# Generated by Django 3.2.9 on 2021-12-10 19:35

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('user', '0003_alter_userusesocialmedia_token'),
    ]

    operations = [
        migrations.RenameField(
            model_name='usersources',
            old_name='last_seen',
            new_name='seen_last',
        ),
    ]
