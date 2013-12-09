def jenkins = hudson.model.Hudson.instance
def view = jenkins.getView("CPP")

view.items.each(){ job ->
  if( ! job.disabled ){
    jenkins.queue.schedule(job)
    println "${job.name} is scheduled"
  }
}