package first.toolbox.plugin;

import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;
import com.jetbrains.toolbox.feature.gateway.GatewayExtension;
import com.jetbrains.toolbox.feature.gateway.RemoteEnvironmentConsumer;
import com.jetbrains.toolbox.feature.gateway.RemoteProvider;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;

public class ChungaChangaGatewayExtension implements GatewayExtension {
    @Override
    public @NotNull RemoteProvider createRemoteProviderPluginInstance(@NotNull RemoteEnvironmentConsumer remoteEnvironmentConsumer) {
        Graph graph = GraphBuilder.directed().build(); // just to validate class loading

        System.out.println("MY GRAPH: " + graph);

        return new RemoteProvider() {
            @Override
            public @NotNull String getId() {
                return "CHUNGA_CHANGA";
            }

            @Override
            public @NotNull String getName() {
                return "ChungaChanga";
            }

            @Override
            public byte[] getSvgIcon() {
                try (InputStream resourceAsStream = ChungaChangaGatewayExtension.class.getResourceAsStream("/icon.svg")) {
                    return resourceAsStream != null ? resourceAsStream.readAllBytes() : new byte[0];
                } catch (IOException e) {
                    return new byte[0];
                }
            }

            @Override
            public boolean canCreateNewEnvironments() {
                return false;
            }

            @Override
            public boolean isSingleEnvironment() {
                return true;
            }

            @Override
            public void newInstancePage() {

            }

            @Override
            public void close() throws IOException {

            }
        };
    }
}
