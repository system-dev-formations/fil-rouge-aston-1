#!/bin/bash

cd ~ || exit

title="save-$(date +'%Y-%m-%d').tar.gz"

tar -czvf "$title" /var/www/html/dokuwiki
gupload "$title" -c devOps
rm "$title"