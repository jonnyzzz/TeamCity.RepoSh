TeamCity.RepoSh
===============

plugin to implement repo.sh version control for TeamCity. This VCS could be used for Android platform builds/checkout/changed monitoring

In this repo you will find:
=============================
- TeamCity server plugin
- With teamcity-plugin.xml
- Plugin version will be patched if building with IDEA build runner in TeamCity
- Run configuration to run/debug plugin under TeamCity (use http://localhost:8111)
- One jar containing
-- server plugin classes
-- server plugin web resources (with pre-configured IDEA settings to support references to TeamCity)
- Uses $TeamCityDistribution$ IDEA path variable as path to TeamCity home (unpacked .tar.gz or .exe distribution)
- Bunch of libraries for most recent needed TeamCity APIs
- Module with TestNG tests that uses TeamCity Tests API


What's next? 
=============
 - Have fun!

