def jobMap = [:]
def csvFile = new File("/home/jenkins/jobs/CSV_EXPORTER/lastSuccessful/archive/jobEmails.txt")
def lines = csvFile.getText('UTF-8').tokenize(",")

lines.each { line ->
    def fields = line.tokenize(";")
    def fieldListEmail = fields[1]
    if (fieldListEmail != null && fieldListEmail != "null") {
        def emailForJob = ""
        def emails = fieldListEmail.tokenize("\n")
        emails.each { email ->
            email = email.replaceAll(/"/, '')
            if (email.contains("/")) {
                email = email.split("/")[1]
            }
            if (!email.contains("@")) {
                email = email + "@synchrotron-soleil.fr"
            }
            emailForJob = emailForJob + " " + email
        }
        emailForJob = emailForJob.trim();
        //println fields[0] + "-->" + emailForJob
        def jobName = fields[0].replaceAll(/"/, '')
        jobMap.put(jobName, emailForJob)
    }
}