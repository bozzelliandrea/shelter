import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.shelter.core.Request;
import org.shelter.core.Response;
import org.shelter.core.Router;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.fail;

public class RESTRouterTest {

    private Router buildRouter() {
        AtomicReference<Integer> runtimeIndex = new AtomicReference<>(0);
        final Map<Integer, String> dataSource = new HashMap<>();
        final Router router = new Router();

        router.get("/resource", (request, response) -> response.send(new ArrayList<>(dataSource.values())));

        router.post("/resource", (request, response) -> {
            final String input = String.valueOf(request.body());

            Assertions.assertNotNull(input);

            dataSource.put(runtimeIndex.get() + 1, input);
            runtimeIndex.updateAndGet(v -> v + 1);
            response.send(input);
        });

        router.put("/resource/:id", (Request request, Response response) -> {
            final Integer id = Integer.valueOf(request.params().get("id"));
            final String input = String.valueOf(request.body());

            Assertions.assertNotNull(id);
            Assertions.assertNotNull(input);

            dataSource.put(id, input);
            response.send(input);
        });

        router.delete("/resource/:id", (request, response) -> {
            final Integer id = Integer.valueOf(request.params().get("id"));

            Assertions.assertNotNull(id);

            dataSource.remove(id);
        });

        return router;
    }

    @Test
    public void build_RESTRouter() {
        Router router = buildRouter();

        router.listen(() -> {
            System.out.println("Up and Running");

            try {
                URL url = new URL("http://localhost:8080/resource");

                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                //TODO: implement 4 requests for exposed api
            } catch (Exception e) {
                fail();
            }
        });
    }

}
