rootProject.name = "pokedex"
include("src:test:Pokedex2")
findProject(":src:test:Pokedex2")?.name = "Pokedex2"
