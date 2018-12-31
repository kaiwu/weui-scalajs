#!/bin/bash
find target/ -name classes | xargs rm -rf
find target/ -name less | xargs rm -rf
find target/ -name streams | xargs rm -rf
find target/ -name *.map | xargs rm -rf
rm -f target/.history
