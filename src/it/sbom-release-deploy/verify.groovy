def repository = new File(basedir, 'target/it-repository/org/example/sbom-release-deploy-it/1.0.0')

assert repository.isDirectory() : "local deploy repository was not created: ${repository}"

[
    'sbom-release-deploy-it-1.0.0.jar',
    'sbom-release-deploy-it-1.0.0.pom',
    'sbom-release-deploy-it-1.0.0-cyclonedx.json',
    'sbom-release-deploy-it-1.0.0-cyclonedx.xml'
].each { name ->
    def artifact = new File(repository, name)
    assert artifact.isFile() : "expected deployed artifact missing: ${artifact}"
    assert artifact.length() > 0 : "expected deployed artifact is empty: ${artifact}"
}

return true
