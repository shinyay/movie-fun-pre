#!/bin/bash

export VCAP_SERVICES='{"p-mysql": [{"credentials": {"jdbcUrl": "jdbc:mysql://127.0.0.1:3306/albums?user=root&password=mysql"}, "name": "albums-mysql"}, {"credentials": {"jdbcUrl": "jdbc:mysql://127.0.0.1:3306/movies?user=root&password=mysql"}, "name": "movies-mysql"}]}'
