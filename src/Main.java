//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    CompletableFuture<String> futureFirstName =  CompletableFuture.supplyAsync(this::getFirstName);
    CompletableFuture<String> futureLastName =  CompletableFuture.supplyAsync(this::getLastName);
    CompletableFuture<String> futureMiddleName =  CompletableFuture.supplyAsync(this::getMiddleName);
    CompletableFuture<String> futureResult = futureFirstName.
            thenCombine(futureMiddleName,(f1,f2) -> f1 + " " + f2).
            thenCombine(futureLastName,(f1,f2) -> f1 + " " + f2);
    try {
        System.out.println(futureResult.get());
    } catch (InterruptedException | ExecutionException e) {
        throw new RuntimeException(e);
    }


}
private String getFirstName()
{
    return "Completable";

}

private String getLastName()
{
    return "Future";

}

private String getMiddleName()
{
    return "For";

}