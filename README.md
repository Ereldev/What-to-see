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

- [] App navigation
- [ ] Categories list
  - [X] Empty state
- [ ] Create & edit category
  - [X] Display search results
  - [X] Search query after 500 ms
  - [X] Empty state for search
  - [ ] Error state with retry for search
  - [ ] Implement paging
  - [ ] Implement save / update
- [ ] Movies & Shows list for a category
  - [ ] Display results
  - [ ] Empty state
  - [ ] Error state with retry
- [ ] Movies & Shows details
  - [ ] Dynamic show data
  - [ ] Cast
- [ ] Settings (no spoil mode)
- [ ] Splash screen with lotite animation 

## iOS

- [ ] Android like implementation

## Global

- [x] Manage dependencies with refreshVersions plugin

## Ideas 

- [ ] Move to TheMovieDB V4 API
- [ ] Notifications (backend required ?)