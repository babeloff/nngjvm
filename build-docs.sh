#!/bin/sh
VERSION="latest"

(cd doc; make)
lein doc
lein javadoc

rm -rf /tmp/nng-doc/
mkdir -p /tmp/nng-doc/

mv doc/index.html /tmp/nng-doc/
mv doc/api /tmp/nng-doc/

git checkout gh-pages;

rm -rf ./$VERSION
mv /tmp/nng-doc/ ./$VERSION

git add --all ./$VERSION
git commit -a -m "Update ${VERSION} doc"
