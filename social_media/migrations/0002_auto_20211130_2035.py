# Generated by Django 3.2.9 on 2021-11-30 17:35

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('social_media', '0001_initial'),
    ]

    operations = [
        migrations.AlterModelTable(
            name='socialmedia',
            table='social_media',
        ),
        migrations.AlterModelTable(
            name='socialmediapublic',
            table='social_media_public',
        ),
    ]
