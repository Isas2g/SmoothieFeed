# Generated by Django 3.2.9 on 2021-12-07 19:51

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('user', '0002_auto_20211130_2035'),
    ]

    operations = [
        migrations.AlterField(
            model_name='userusesocialmedia',
            name='token',
            field=models.CharField(max_length=200, unique=True),
        ),
    ]
