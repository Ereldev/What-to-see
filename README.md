# What-to-see
Android & iOS app to list future movies & series releases dates  
  
It's a portfolio app, not sure if I will publish it.  
  
This app is realized with KMM framework, Compose for Android views & SwiftUI for iOS views.  
  
# Project architecture

The project dependencies are maintained with [refreshVersions](https://jmfayard.github.io/refreshVersions/] gradle plugin)  

TODO: schematic

# TODO

## Shared

- [X] REST Client
- [X] API services & repositories for movies
- [ ] API services & repositories for credits
- [ ] Local saving for categories

## Android

- [X] App navigation
- [ ] Categories list
  - [X] Empty state
- [ ] Create & edit category
  - [ ] Display search results
  - [ ] Search query after 2 char & 500 ms
  - [ ] Empty state for search
  - [ ] Error state for search
  - [ ] Implement paging
- [ ] Movies & Shows list for a category
  - [ ] Display results
  - [ ] Empty state
  - [ ] Error state with retry
- [ ] Movies & Shows details
- [ ] Settings (no spoil mode)
- [ ] Splash screen with lotite animation 

## iOS
    
- [ ] Android like implementation

## Global

- [x] Manage dependencies with refreshVersions plugin

## Ideas 

- [ ] Move to TheMovieDB V4 API
- [ ] Notifications (backend required ?)