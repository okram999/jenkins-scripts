import hudson.model.*
import hudson.maven.*
import hudson.tasks.*
import hudson.scm.*

hudsonInstance = hudson.model.Hudson.instance
allItems = hudsonInstance.items
//seltectedItems = allItems.findAll{job -> job.name.contains("org.tango.server.TestDevice_JAR")}
for(item in allItems) {
  if (item.scm instanceof SubversionSCM)
  {
    if(item.scm.workspaceUpdater instanceof hudson.scm.subversion.UpdateUpdater) { 
      println("\njob $item.name")
      item.scm.workspaceUpdater = new hudson.scm.subversion.CheckoutUpdater();
    }
    item.save()
      
  }
}