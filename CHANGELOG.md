OwnTracks Android App Release Notes
===================================
## OwnTracks 0.5.14
>Release date: 2015-06-XX for alpha testers
* [FIX] #192 - Autostart on boot should be default
* [FIX] #198 - Desc attribute not present in transition event
* [FIX] #196 - Tid not configurable in hosted mode
* [FIX] Unable to save username
* [NEW] More granular resolving of Geocoder

## OwnTracks 0.5.13
>Release date: 2015-06-16 for alpha testers
* [FIX] #191 - First launch after clean install should be in Public mode
* [FIX] #193 - Battery level not included in location pubs 
* [FIX] #195 - Preferences were not loaded correctly after mode change
* [FIX] #197 - Race condition in message delivery callbacks
* [FIX] #201 - Missing text styles in Waypoint edit dialog
* [FIX] Restricted setting of preference keys from imported config in public and hosted mode
* [FIX] SQLite database was not initialized correctly after updating from a previous schema version

## OwnTracks 0.5.12
>Release date: 2015-06-15 for alpha testers
* [FIX] Recursive entries to multiple views
* [FIX] #184 - Crash in org.owntracks.android.services.ServiceLocator.requestGeofences  
* [FIX] #180 - Crash if the received lat value is >90 or lon >180 
* [FIX] #178 - Crash in org.owntracks.android.activities.ActivityImport.extractPreferences
* [FIX] #143 - t parameter missing when reporting location from notification bar
* [FIX] Map zoom on orientation change
* [FIX] Geofences were not respecting the currently set mode
* [FIX] Connect and disconnect button was not working correctly
* [NEW] Added wtst to waypoint transition messages
* [NEW] removed enter or leave from waypoint definitions
* [NEW] Added mode switcher 
* [NEW] Added public mode support 
* [NEW] Added hosted mode support 
* [NEW] Updated external libraries to current versions
* [NEW] Reworked navigation sidebar
* [NEW] Fixed toolbars in preferences